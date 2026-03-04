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
    private var scoreA = 0
    private var scoreB = 0

    private var alertMao11ShownA = false
    private var alertMao11ShownB = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPlus1A.setOnClickListener { addPoints("A", 1) }
        binding.btnPlus3A.setOnClickListener { addPoints("A", 3) }

        binding.btnPlus1B.setOnClickListener { addPoints("B", 1) }
        binding.btnPlus3B.setOnClickListener { addPoints("B", 3) }

        binding.btnReset.setOnClickListener { resetGame() }
    }

    private fun addPoints(team: String, points: Int) {
        if (team == "A") {
            scoreA += points
        } else {
            scoreB += points
        }
        updateUIAndCheckGameState()
    }

    private fun updateUIAndCheckGameState() {
        binding.tvScoreA.text = scoreA.toString()
        binding.tvScoreB.text = scoreB.toString()

        binding.btnPlus3A.isEnabled = scoreA < 11
        binding.btnPlus3B.isEnabled = scoreB < 11

        if (scoreA >= 12) {
            showWinner("Equipe A")
        } else if (scoreB >= 12) {
            showWinner("Equipe B")
        } else {
            checkMaoDe11()
        }
    }

    private fun checkMaoDe11() {
        if (scoreA == 11 && scoreB == 11 && (!alertMao11ShownA || !alertMao11ShownB)) {
            alertMao11ShownA = true
            alertMao11ShownB = true
            showAlertDialog("Atenção: Mão de 11!", "Ambas as equipes estão com 11 pontos. Jogo no escuro!")
        }
        else if (scoreA == 11 && !alertMao11ShownA) {
            alertMao11ShownA = true
            showAlertDialog("Atenção: Mão de 11!", "A Equipe A está na mão de 11!")
        }
        else if (scoreB == 11 && !alertMao11ShownB) {
            alertMao11ShownB = true
            showAlertDialog("Atenção: Mão de 11!", "A Equipe B está na mão de 11!")
        }
    }
    private fun showAlertDialog(title: String, message: String) {
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show()
    }
    private fun showWinner(winningTeam: String) {
        AlertDialog.Builder(this)
            .setTitle("Fim de Jogo")
            .setMessage("A $winningTeam venceu a partida!")
            .setPositiveButton("Nova Partida") { _, _ -> resetGame() }
            .setCancelable(false)
            .show()
    }
    private fun resetGame() {
        scoreA = 0
        scoreB = 0
        alertMao11ShownA = false
        alertMao11ShownB = false
        binding.btnPlus3A.isEnabled = true
        binding.btnPlus3B.isEnabled = true
        binding.tvScoreA.text = scoreA.toString()
        binding.tvScoreB.text = scoreB.toString()
    }




}