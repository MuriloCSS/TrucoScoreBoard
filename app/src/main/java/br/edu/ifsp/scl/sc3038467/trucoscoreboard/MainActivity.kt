package br.edu.ifsp.scl.sc3038467.trucoscoreboard

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
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


}