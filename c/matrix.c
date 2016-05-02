#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>

#define N 10

int matrix1 [N][N];
int matrix2 [N][N];
int sum_result [N][N];
int times_result [N][N];

void printMatrix(int m[N][N]){
  for(int i =0; i<N; i++){
    for(int j =0; j<N; j++){
        printf("%i ", m[i][j]);
    }
    printf("\n");
  }
}
void init_matrix(int m[N][N]) {
	for (int i = 0; i < N; ++i)	{
		for (int j = 0; j < N; ++j) {
			m[i][j] = rand() % 100;
		}
	}
  printMatrix(m);
}

void add(void* arg){
  int* intArg = (int*) arg;
  int row = *intArg;
  for(int j=0; j<=N; j++){
    sum_result[row][j] = matrix1[row][j] + matrix2[row][j];
  }
  pthread_exit(NULL);
}

void times(void* arg){
  int* intArg = (int*) arg;
  int row = *intArg;
  int sum=0;
  for(int i =0;i<N;i++){
    for(int j=0; j<N;j++){
      sum = sum + (matrix1[row][j] * matrix2[j][i]);
    }
    times_result[row][i]=sum;
    sum=0;
  }
  pthread_exit(NULL);
}

int main (){
  printf("%s\n", "Matriz A");
  init_matrix(matrix1);
  printf("%s\n", "Matriz B");
  init_matrix(matrix2);
  printf("--------------------------------\n");
  printf("--------------------------------\n");
  int rows[N];
  pthread_t threads_sum[N];
  pthread_t threads_times[N];
  for (int i =0; i<N; i++){
    rows[i]=i;
    pthread_create(&threads_sum[i], NULL, (void*)&add, (void*)&rows[i]);
  }
  printf("%s\n", "resultado suma");
  printMatrix(sum_result);
  printf("--------------------------------\n");
  printf("--------------------------------\n");
  for (int i =0; i<N; i++){
    rows[i]=i;
    pthread_create(&threads_times[i], NULL, (void*)&times, (void*)&rows[i]);
  }
  printf("%s\n", "resultado multiplicacion");
  printMatrix(times_result);

}
