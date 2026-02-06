public class Tiket {

    public Tiket(){

    }//Constructor por default

    private final double DESCUENTO = 0.10;
    private final double PRECIO = 10;
    public double subtotal;
    public double decuentoCalculado;
    public double total;


    public void process(int cantidad){
        CalcularSubtotal(cantidad);
        calcularDescuento(this.subtotal);
        calcularTotal(this.subtotal);
    }

    private void CalcularSubtotal(int cantidad){
        this.subtotal = cantidad*PRECIO;
    }

    private void calcularDescuento(double subtotal){
        this.decuentoCalculado= subtotal*DESCUENTO;
    }

    private void calcularTotal(double subtotal){
        this.total= subtotal- this.decuentoCalculado;
    }

    public void imprimirTicket(double cantidad){
        System.out.println("---Ticket---");
        System.out.println("Cantidad de articulos fue: "+cantidad);
        System.out.println("Subtotal: "+this.subtotal);
        System.out.println("El descuento calculado es de:  "+ this.decuentoCalculado);
        System.out.println("Totaln de la compra: " + this.total);
        System.out.println("---Ticket---");
    }
}
