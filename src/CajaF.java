/*
* Metodos :
*  abrir
* cerrar
*
* */

import java.util.Scanner;

class Cajafuerte {
    Scanner scanner = new Scanner(System.in);
    private int pin;
    private boolean abierta;
    public int intentos;


 public Cajafuerte() {
  this.pin = 0000;
  this.abierta = false;
  this.intentos = 0;

 }
 public void setPin(){
  System.out.println("Digite el pin actual");
  int pinActual = scanner.nextInt();
  if (abierta || pinActual == pin){
   System.out.println("digite el nuevo pin");
   int pinNuevo = scanner.nextInt();
   this.pin = pinNuevo;
  }else{
   System.out.println("Digite el pin actual correctamente o asegurese de que la caja este abierta");
  }
 };





 public boolean VerificarPin(int pinIngresado) {

   if (pinIngresado == pin) {
    abierta = true;
    return true;
   } else {
    intentos++;
    return false;
   }
  }
 }



}







