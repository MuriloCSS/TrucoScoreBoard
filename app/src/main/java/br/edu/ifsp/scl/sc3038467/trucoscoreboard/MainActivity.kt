package br.edu.ifsp.scl.sc3038467.trucoscoreboard

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.ifsp.scl.sc3038467.trucoscoreboard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var pontosA = 0
    private var pontosB = 0

    private var alertaMao11A = false
    private var alertaMao11B = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1A.setOnClickListener { addPoints("A", 1) }
        binding.btn3A.setOnClickListener { addPoints("A", 3) }

        binding.btn1B.setOnClickListener { addPoints("B", 1) }
        binding.btn3B.setOnClickListener { addPoints("B", 3) }

        binding.btnReset.setOnClickListener { resetGame() }
    }

    private fun addPoints(team: String, points: Int) {
        if (team == "A") {
            pontosA += points
        } else {
            pontosB += points
        }
    }


    private fun showAlertDialog(title: String, message: String) {
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show()
    }



    private fun checkMaoDe11() {
        if (pontosA == 11 && pontosB == 11 && (!alertaMao11A || !alertaMao11B)) {
            alertaMao11A = true
            alertaMao11B = true
            showAlertDialog("Atenção: Mão de 11!", "Ambas as equipes estão com 11 pontos. Jogo no escuro!")
        }
        else if (pontosA == 11 && !alertaMao11A) {
            alertaMao11A = true
            showAlertDialog("Atenção: Mão de 11!", "A Equipe A está na mão de 11!")
        }
        else if (pontosB == 11 && !alertaMao11B) {
            alertaMao11B = true
            showAlertDialog("Atenção: Mão de 11!", "A Equipe B está na mão de 11!")
        }
    }

    private fun showWinner(winningTeam: String) {
        AlertDialog.Builder(this)
            .setTitle("Fim de Jogo")
            .setMessage("$winningTeam ganhou a partida!")
            .setPositiveButton("Nova Partida") { _, _ -> resetGame() }
            .setCancelable(false)
            .show()
    }

    private fun resetGame() {
        pontosA = 0
        pontosB = 0
        alertaMao11A = false
        alertaMao11B = false
        binding.btn3A.isEnabled = true
        binding.btn3B.isEnabled = true
        binding.tvPontosA.text = pontosA.toString()
        binding.tvPontosB.text = pontosB.toString()
    }


}