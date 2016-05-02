#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
  for (int i =0; i< argc; i++){
    printf("#%d : %s\n", i, argv[i]);
  }

  if (argc == 1){
    exit(1);
  }

  exit(0);
}

//find-identify -verbose-md5-
