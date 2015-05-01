package kmeans;

public class Main {
    public static void main(String[] args) {
     
    Movies mv = new Movies();
    for(int t=0; t<5;t++){
     mv.calcular();
     mv.actualizarCentroide(mv.c1,0);
     mv.actualizarCentroide(mv.c2,1);
     mv.actualizarCentroide(mv.c3,2);
     mv.actualizarCentroide(mv.c4,3);
    
     //centroide actualizado
     for(int i=0;i<mv.centroides.length;i++){
         System.out.println("\t");
         for(int j=0;j<4;j++){
              System.out.println(mv.centroides[i][j]+"\t");
                } 
            }
      System.out.println("//////////////////////////////");
      if(t!=4){
      mv.c1.clear();
      mv.c2.clear();
      mv.c3.clear();
      mv.c4.clear();
            }
        }
    //Despues de 5 iteraciones asi quedan organizadas las peliculas
      mv.imprimeArray(mv.c1,1);
      mv.imprimeArray(mv.c2,2);
      mv.imprimeArray(mv.c3,3);
      mv.imprimeArray(mv.c4,4);
    }
}
    