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


    private fun addPoints(team: String, points: Int) {
        if (team == "A") {
            scoreA += points
        } else {
            scoreB += points
        }
    }


}