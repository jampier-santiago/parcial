class Votacion {
    val candidatos: MutableList<Representante> = mutableListOf();
    var totalVotos: Int = 0

    fun agregarCandidato(representante: Representante) {
        candidatos.add(representante);
    }

    fun votarPorCandidato(numeroCarton: Int, medio: Canal) {
        val representante = candidatos.find { it.numeroCarton == numeroCarton };

        if (representante != null) {
            representante.agregarVotos(medio);
            totalVotos++;
        }
    }

    fun ganadorVotacion() {
        var ganador: Representante? = null;
        var votosGanador: Int = 0;

        for (candidato in candidatos) {
            if (candidato.totalVotos() > votosGanador) {
                ganador = candidato;
                votosGanador = candidato.totalVotos();
            }
        }

        if (ganador != null) {
            println("El ganador es ${ganador.nome} con ${votosGanador} votos");
        } else {
            println("No hay ganador");
        }
    }

    fun costoPromedioCampaña() {
        var costoTotal: Int = 0;

        for (candidato in candidatos) {
            costoTotal += candidato.calcularCostoCamapaña();
        }

        println("El costo promedio de la campaña es ${costoTotal / candidatos.size}");
    }

    fun costoCampañaPorCandidato(numeroCarton: Int) {
        val representante = candidatos.find { it.numeroCarton == numeroCarton };

        if (representante != null) {
            println("El costo de la campaña de ${representante.nome} es ${representante.calcularCostoCamapaña()}");
        }
    }

    fun totalVotos() {
        var votos: Int = 0;

        for (candidato in candidatos) {
            votos += candidato.totalVotos();

            println("El total de votos de ${candidato.nome} es ${candidato.totalVotos()}");
        }

        println("El total de votos es ${votos}");
    }

    fun limpiarVotos() {
        totalVotos = 0;

        for (candidato in candidatos) {
            candidato.limpiarVotos();
        }
    }

    fun porcantajeVotosPorCandidato() {
        for (candidato in candidatos) {
            println("El porcentaje de votos de ${candidato.nome} es ${candidato.totalVotos() * 100 / totalVotos}%");
        }
    }

}