#include <stdio.h>

struct file_s {
    size_t debut, fin, capacite;
    int *elements;
};
typedef struct file_s file_t;

file_t *alloue_file(size_t capacite) {
    if(capacite <= 0) return NULL;
    file_t *f = malloc(sizeof(file_t));

     = malloc(sizeof(int) * capacite);
}

void libere_file(file_t *file) {
    free(file);
}


