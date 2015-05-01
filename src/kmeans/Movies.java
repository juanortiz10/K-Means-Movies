package kmeans;
import java.util.ArrayList;

public class Movies {
    ArrayList<Integer>c1=new ArrayList();
    ArrayList<Integer>c2=new ArrayList();
    ArrayList<Integer>c3=new ArrayList();
    ArrayList<Integer>c4=new ArrayList();
    double centroides[][]={{0.0,0.0,0.0,10.0},{0.0,0.0,10.0,0.0},{0.0,10.0,0.0,0.0},{10.0,0.0,0.0,0.0}};
    double[][]resultados= new double[20][4];
    int calidad[][]={{5,10,10,0},{3,8,7,0},{5,6,5,0},{9,8,7,0},{3,0,8,7},{0,0,10,10},{2,0,9,10},{10,9,8,2},{10,2,3,1},
        {10,7,10,0},{10,10,10,0},{0,8,5,0},{10,9,10,2},{10,5,10,3},{10,10,10,0},{10,6,5,3},{10,7,6,3},{2,10,3,2},{10,9,7,0},
        {10,10,9,0}}; 
    
    public double disEuclidiana(double x1,double y1,double z1,double a1,double x2,double y2,double z2,double a2){
        return Math.sqrt(Math.pow(x2-x1,2)+(Math.pow(y2-y1,2))+(Math.pow(z2-z1,2))+(Math.pow(a2-a1,2)));
    }
    public void imprimeMatriz(){
		for(int i=0;i<calidad.length;i++){
			for(int j=0;j<4;j++){
				System.out.print(calidad[i][j]+"\t");
			}
		System.out.println("");
			}
                System.out.println("\n\n");
		}
    public void imprimeArray(ArrayList n,int numero){
        System.out.println("C"+numero+":");
       for(int i = 0; i<n.size();i++){
           System.out.println(""+n.get(i)+"\t");
       }
    }
    /*Funcion calcular se utiliza para calcular las distancias euclidianas obteniendo los valores de los
    centroides y de las peliculas, despues lo ordena con su centroide mas cercano
    */
    public void calcular(){
          double menor=20.0;
          int posicion = 0;
          
          for(int i =0; i<calidad.length;i++){
              for(int j=0;j<4;j++){    
                    double x1=centroides[j][0];
                    double y1=centroides[j][1];
                    double z1=centroides[j][2];
                    double a1=centroides[j][3];
                    double x2=calidad[i][0];
                    double y2=calidad[i][1];
                    double z2=calidad[i][2];
                    double a2=calidad[i][3];
                    double total=disEuclidiana(x1,y1,z1,a1,x2,y2,z2,a2);
                    resultados[i][j]=total;
                    if(total<menor){
                       menor=total;
                       posicion=j;
                    }
                    if(j==3){
                      switch(posicion){
                          case 0:
                          c1.add(calidad[i][0]);
                          c1.add(calidad[i][1]);
                          c1.add(calidad[i][2]);
                          c1.add(calidad[i][3]);
                          break;
                          case 1:
                          c2.add(calidad[i][0]);
                          c2.add(calidad[i][1]);
                          c2.add(calidad[i][2]);
                          c2.add(calidad[i][3]);
                          break;
                          case 2:
                          c3.add(calidad[i][0]);
                          c3.add(calidad[i][1]);
                          c3.add(calidad[i][2]);
                          c3.add(calidad[i][3]);
                          break;
                          case 3:
                          c4.add(calidad[i][0]);
                          c4.add(calidad[i][1]);
                          c4.add(calidad[i][2]);    
                          c4.add(calidad[i][3]);
                          break;   
                      }
                      menor=20.0;
                    }   
                }
            }
        }
    
    //Esta funcion sirve para actualizar el centroide despues de haber terminado una iteracion.
    public void actualizarCentroide(ArrayList centroide,int numero){
        int n1=0,n2=0,n3=0,n4=0;
          int counter =0,counter2=0;
            for(int i = 0; i<centroide.size(); i++){
                int val=(int) centroide.get(i);
                if(counter==0){
                    n1=n1+val;
                    counter++;
                }else if(counter==1){
                    n2=n2+val;
                    counter++;
                }else if(counter==2){
                    n3=n3+val;
                    counter++;
                }else if(counter==3){
                    n4=n4+val;
                    counter=0;
                    counter2++;
                }
            }
            double val1=n1/counter2;
            double val2=n2/counter2;
            double val3=n3/counter2;
            double val4=n4/counter2;
            //Asignar este valor al nuevo centroide
            centroides[numero][0]=val1;
            centroides[numero][1]=val2;
            centroides[numero][2]=val3;
            centroides[numero][3]=val4;         
        }
}

    