fun main() {

    var terminarPrograma: Boolean = false
    val votacion: Votacion = Votacion()

    fun cargarCandidatos() {
        val candidato1: Representante = Representante("Candidato 1", 1)
        val candidato2: Representante = Representante("Candidato 2", 2)
        val candidato3: Representante = Representante("Candidato 3", 3)

        votacion.agregarCandidato(candidato1)
        votacion.agregarCandidato(candidato2)
        votacion.agregarCandidato(candidato3)
    }

    fun verCandidatos() {
        for (candidato in votacion.candidatos) {
            println("Nombre: ${candidato.nome} - Número de cartón: ${candidato.numeroCarton}")
        }

        println("")
        println("-------------------------")
    }

    fun votar() {
        println("Ingrese el número de cartón del candidato:")
        val numeroCarton: Int = readLine()?.toInt() ?: 0

        println("Ingrese el medio por el cual vota:")
        println("1. Internet")
        println("2. Radio")
        println("3. TV")
        val opcion: Int = readLine()?.toInt() ?: 0

        when (opcion) {
            1 -> votacion.votarPorCandidato(numeroCarton, Canal.INTERNET)
            2 -> votacion.votarPorCandidato(numeroCarton, Canal.RADIO)
            3 -> votacion.votarPorCandidato(numeroCarton, Canal.TV)
            else -> println("Opción no válida")
        }

        println("Voto registrado")
    }

    fun costoCampañaPorCandidato() {
        println("Ingrese el número de cartón del candidato:")
        val numeroCarton: Int = readLine()?.toInt() ?: 0

        votacion.costoCampañaPorCandidato(numeroCarton)
    }

    fun limpiarVotos() {
        votacion.limpiarVotos()
        println("Votos limpiados")
    }

    fun totalVotos() {
        votacion.totalVotos()


    }

    fun porcentajeVotosPorCandidato() {
        votacion.porcantajeVotosPorCandidato()
    }

    fun costoPromedioCampaña() {
        votacion.costoPromedioCampaña()
    }

    fun ganadorVotacion() {
        votacion.ganadorVotacion()
    }

    fun empezarVotacion() {
        println("Menu de opciones")

        println("-----------------")

        println("1. Ver todos los candidatos")
        println("2. Votar")
        println("3. Calcular costo de la campaña por candidato")
        println("4. Vaciar votos")
        println("5. Total de votos")
        println("6. Porcentaje de votos por candidato")
        println("7. Costo promedio de la campaña")
        println("8. Ganador de la votación")
        println("9. Salir")

        println("-----------------")

        println("Ingrese una opción:")
        val opcion: Int = readLine()?.toInt() ?: 0

        when (opcion) {
            1 -> verCandidatos()
            2 -> votar()
            3 -> costoCampañaPorCandidato()
            4 -> limpiarVotos()
            5 -> totalVotos()
            6 -> porcentajeVotosPorCandidato()
            7 -> costoPromedioCampaña()
            8 -> ganadorVotacion()
            9 -> terminarPrograma = true
            else -> println("Opción no válida")
        }
    }

    cargarCandidatos()

    do {
        empezarVotacion()

    } while (!terminarPrograma)
}