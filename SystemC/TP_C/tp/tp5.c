#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <math.h>

struct node {
    int val;
    struct node *next;
};
typedef struct node node;

node* getNode(int val, node* n){
    node* out = (node*) malloc(sizeof(node));
    if (out != NULL){
        out->val = val;
        out->next = n;
    }
    return out;
}

node* genlist(int size, int max) {
    if (size == 0 || max == 0) return NULL;
 
    node* n = NULL;
 
    for (int i = 0; i < size; i++)
        n = getNode(rand() % max, n);

    return n;
}

void prlist(node* n){
    if (n != NULL){
        do
            printf("%d ", n->val);
        while ((n = n->next));
        printf("\n");
    }
}

short verifsort(node* l, int n){
    int value = 0;
    for (; n > 0 && l != NULL; n--, value = l->val, l = l->next){
        if (l->val < value)
            return 0;
    }
    return l == NULL && n == 0;
}

struct part {
    node *lg;
    node *pivot;
    node *ld;
};
typedef struct part part;

part partition (node *l) {
    // cas initiaux.
    if (l == NULL)
        return (part) {NULL, NULL, NULL};
    if (l->next == NULL)
        return (part) {NULL, l, NULL};
 
    node *n = NULL, *p = NULL, *r = NULL, *current;
 
    p = l; // pivot
    current = l->next; // current node
    l = current->next; // next node
    p->next = NULL; // pivot sans next
 
    while (1) {
        if (current->val > p->val) {
            current->next = r;
            r = current;
        }
        else {
            current->next = n;
            n = current;
        }
 
        current = l;
        if (current == NULL) break;
        l = l->next;
    }
    part out = { n, p, r };
    return out;
}

// ajoute b à la suite de a.
node* append(node* a, node* b) {
    if(a == NULL) return b;
    if(b == NULL) return a;

    node* n = a;

    while((n->next)) n = n->next;

    n->next = b;
    return a;
}

node* trirapide(node *l) {
    if(l == NULL || l->next == NULL) return l;

    part p = partition(l);

    if(p.lg != NULL) p.lg = trirapide(p.lg);
    if(p.ld != NULL) p.ld = trirapide(p.ld);

    return append(p.lg, append(p.pivot, p.ld));
}

// libère tous les nodes suivants de n et n.
void free_nodes (node* n) {
    if (n == NULL) return;

    node* tmp = n->next;

    while (n != NULL){
        free(n);
        n = tmp;
        if (tmp != NULL)
            tmp = tmp->next;
    }
    
}

short funcheck(int n, int m){
    node* l = NULL;

    while (m > 0) {
        m--;
        l = genlist(n, n);
        l = trirapide(l);
 
        short s = verifsort(l, n);

        if (!s){
            free_nodes(l);
            return 0;
        }
        free_nodes(l);
    }
    free_nodes(l);
    return 1;
}

double timecheck (int n, int m) {
    node* l = NULL;
    int size = (int) pow(2, 6);

    for (int i = 6; i <= m; i ++){
        clock_t time = 0;
 
        for (int j = 0; j < n; j ++){
            l = genlist(size, size);
            time -= clock();
            // if (algo)
            //     l = triRapide(l);
            // else
            //     l = triBulle(l);

            l = trirapide(l);
            time += clock();
 
            if (! verifsort(l, size)){
                printf("Liste mal triée.\n");
                free_nodes(l);
                return 0;
            }
            free_nodes(l);
        }

        printf("%s - %d - taille %d - %f s\n", "triRapide", n, size, (double) time / (CLOCKS_PER_SEC * n));
        size *= 2;
    }
    free_nodes(l);
    return 1;
}
 
int main (){
    srand((unsigned) time(0));

    if (!timecheck(2, 20))
        printf("Erreur dans le tri rapide.\n");

    return 0;
}
