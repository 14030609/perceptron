import java.util.Random;
import javax.swing.JOptionPane
import Patrones

fun main(args: Array<String>) {
    val r = Random()

    val listaPesos: ArrayList<Double> = ArrayList()
    val i = 0
    val umbral = 0.2
    var salidaActual = 0
    var cont = 0
    val patrones: ArrayList<Patrones> = ArrayList()
    val errores: ArrayList<Int> = ArrayList()
    var bandera=1


    patrones.add(Patrones(intArrayOf(0, 0), 0))
    patrones.add(Patrones(intArrayOf(0, 1), 0))
    patrones.add(Patrones(intArrayOf(1, 0), 0))
    patrones.add(Patrones(intArrayOf(1, 1), 1))


    val tasaAprendizaje: Double = 0.1


    val min2: Double = JOptionPane.showInputDialog("ingrese el valor minimo del rango de pesos").toDouble()
    val max2: Double = JOptionPane.showInputDialog("ingrese el valor maximo del rango de pesos").toDouble()




    for (i in 0 until (patrones.size*2)) {
        listaPesos.add(min2 + (max2 - min2) * r.nextDouble())
    }


    listaPesos.forEach {
        println(" pesos $it")

    }

    println("umbral $umbral")


    while (bandera==1)
    {
        bandera=0
        patrones.forEach {


            val pesos: ArrayList<Double> = ArrayList()
            pesos.add(listaPesos.get(cont))
            pesos.add(listaPesos.get(cont+1))

            val n = Neurona(pesos,it.entradas,umbral)
            cont++

            println()
            if (n.obtenerSalida() < 0)
            {
                salidaActual=0
            }else
                salidaActual=1


            println("salidaActual $salidaActual")

            if (salidaActual== it.salidaEsperada)
            {
                errores.add(0)
            }else
                errores.add(it.salidaEsperada-salidaActual)


        }




        for (i in 0 until errores.size )
        {

            println(errores.get(i))
            if (errores.get(i)!=0)
            {
                listaPesos.set(i*2, listaPesos.get(i*2)+errores.get(i)*tasaAprendizaje*patrones.get(i).entradas.get(0))
                listaPesos.set((i*2)+1,listaPesos.get((i*2)+1)+errores.get(i)*tasaAprendizaje*patrones.get(i).entradas.get(1))
                bandera =1
            }
        }
cont=0
//        print( "contador $cont    $bandera")
        errores.clear()
    }


}
