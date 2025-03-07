/*
* Metodos :
*  abrir
* cerrar
*
* */
import java.util.ArrayList;
import java.util.Scanner;

class Cajafuerte {
    Scanner scanner = new Scanner(System.in);
    private int pin = 0000;
    private boolean abierta;
    private int intentos = 0;
    private ArrayList<String> objetos;
    private static final int MAX_INTENTOS = 10;


 public Cajafuerte() {
  this.pin = 0000;
  this.setAbierta(false);
  this.setIntentos(0);
  objetos = new ArrayList<>();

 }


 // TODO-si la caja esta bloqueda no deberia dejar cambiar la contraseña
 public void setPin(){
  System.out.println("Digite el pin actual");
  int pinActual = scanner.nextInt();
  if (isAbierta() || pinActual == pin){
   System.out.println("digite el nuevo pin");
   int pinNuevo = scanner.nextInt();
   this.pin = pinNuevo;
  }else{
   System.out.println("Digite el pin actual correctamente o asegurese de que la caja este abierta");
  }
 };




// Verificar pin y intentos
 public boolean VerificarPin(int pinIngresado) {

   if (pinIngresado == pin) {
    setAbierta(true);
    return true;
   } else {;
    return false;
   }
  }

 public boolean estaBloqueada() {
  return intentos >= MAX_INTENTOS;
 }



 public int getIntentos() {
  return intentos;
 }


 public void setIntentos(int intentos) {
  this.intentos = intentos;
 }

 public boolean isAbierta() {
  return abierta;
 }

 public void setAbierta(boolean abierta) {
  this.abierta = abierta;
 }



 //Modificar contenido de la caja

 public void agregarObjeto(String objeto) {
  if (abierta) {
   objetos.add(objeto);
  }
 }

 public boolean eliminarObjeto(String objeto) {
  if (abierta) {
   return objetos.remove(objeto);
  }
  return false;
 }

 public void mostrarObjetos() {
  for (int i = 0; i < objetos.size(); i++) {
   System.out.println((i + 1) + ". " + objetos.get(i));
  };
 }


}









