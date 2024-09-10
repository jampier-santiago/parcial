enum class Canal {
    INTERNET,
    RADIO,
    TV
}

class Representante {
    var nome: String = ""
    var numeroCarton: Int = 0;
    val costoCampañaInternet: Int = 700000;
    val costoCampañaRadio: Int = 200000;
    val costoCampañaTV: Int = 600000;

    var votosPorInternet: Int = 0;
    var votosPorRadio: Int = 0;
    var votosPorTV: Int = 0;

    constructor(nome: String, numeroCarton: Int) {
        this.nome = nome;
        this.numeroCarton = numeroCarton;
    }

    fun agregarVotos(medio: Canal) {
        when (medio) {
            Canal.INTERNET -> votosPorInternet++;
            Canal.RADIO -> votosPorRadio++;
            Canal.TV -> votosPorTV++;
        }
    }

    fun calcularCostoCamapaña(): Int {
        return (costoCampañaInternet * votosPorInternet) + (costoCampañaRadio * votosPorRadio) + (costoCampañaTV * votosPorTV);
    }

    fun limpiarVotos() {
        votosPorInternet = 0;
        votosPorRadio = 0;
        votosPorTV = 0;
    }

    fun totalVotos(): Int {
        return votosPorInternet + votosPorRadio + votosPorTV;
    }
}