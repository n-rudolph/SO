#include <sys/types.h>
#include <sys/wait.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>



int main( int arcs, char* argv[]) {

      int concurrent = atoi(argv[1]);
      int running = 0;
      for (int i = 3; i < arcs; i++) {
          if (running == concurrent){
            pid_t child = wait(NULL);
            printf("1 Child %d Complete\n", child);
            running--;
          }
          running++;
          pid_t pid = fork();

          char* program = argv[2];
          if (pid < 0) {
              fprintf(stderr, "Fork Failed\n");
     	    return 1;
          }
          else if (pid == 0) {
              // child
              char newstring[strlen(program) + strlen(argv[i]) + 2];
              snprintf(newstring, sizeof newstring, "%s %s", program, argv[i]);

              char* sargs[]={"sh", "-c", newstring, argv[i], 0};

              execvp("sh", sargs);
              exit(0);
          }
          else {
  	    /* parent will wait for the child to complete */
          }
      }

      for (int i = 0; i < concurrent; i++) {
        pid_t child = wait(NULL);
        printf("Child %d Complete\n", child);
      }

    return 0;
}
