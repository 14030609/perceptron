class  Neurona (val listaPesos: ArrayList<Double>,val listaentradas: IntArray, val umbral: Double ){
  //  val listaPesos: ArrayList<Double> = ArrayList()
    //val listaentradas: ArrayList<Double> = ArrayList()

    fun  obtenerSalida():Double{


        var wx =0.0
        var y1=0.0

        val i=0
        for (i in 0 until listaentradas.size)
        {
            wx=wx+(listaPesos.get(i) *listaentradas.get(i))


          println ("   entradas ${listaentradas.get(i)}")
            println ("   pesos ${listaPesos.get(i)} ")
println(i)
        }
            y1 = wx-umbral//Salida
//            y1 = Math.sinh(wx) //Salida

        return y1
    }



}