#include <pthread.h>
//para que compile hay que agregar -lpthread o -pthread
//void* es un puntero generico.
void func1(void * arg){

}
void func2(void * arg){

}
int main (){
  pthread_t t1; //sirven como puntero para mantener el estado del thread
  pthread_t t2;
  pthread_create(&t1, NULL, (void*)&func1, NULL); //crea un thred que devuelve un entero con el numero de la creacion. Guarda los datos del thread en la direccion de t1
  //El primer NULL es la configuracion del thread
  //el (void*) es para que la funcion pueda devolver cualquier cosa, Es para que soporte funciones genericas.
  //el ultimo NULL es el argumento que se le pasa a la funcion.
  pthread_create(&t2, NULL, (void*)&func2, NULL);
  pthread_join(t1, NULL);
  pthread_join(t2, NULL);

}
