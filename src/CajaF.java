/*
* Metodos :
*  abrir
* cerrar
*
* */


class Cajafuerte {
 private int pin;
 private boolean abierta;
 public int intentos;

 public Cajafuerte() {
  this.pin = 0000;
  this.abierta = false;
  this.intentos = 0;

 }


 public void setPin(int pin) {
  this.pin = pin;
 }
public
 public boolean estaAbierta() {
  return abierta;
 }

 public void setAbierta(boolean abierta) {
  this.abierta = abierta;
 }
}