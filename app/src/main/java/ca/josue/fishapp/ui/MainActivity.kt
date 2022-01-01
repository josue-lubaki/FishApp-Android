package ca.josue.fishapp.ui

import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ca.josue.fishapp.R
import ca.josue.fishapp.ui.fragment.CommandesFragment
import ca.josue.fishapp.ui.fragment.HomeFragment
import ca.josue.fishapp.ui.fragment.ProfileFragment
import ca.josue.fishapp.ui.util.FragmentUtils.Companion.loadFragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation

class MainActivity : AppCompatActivity() {
    lateinit var navBar : MeowBottomNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navBar = findViewById(R.id.navBar)
        supportActionBar?.hide()
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        // add menu item
        navBar.add(MeowBottomNavigation.Model(1, R.drawable.ic_home))
        navBar.add(MeowBottomNavigation.Model(2, R.drawable.ic_commandes))
        navBar.add(MeowBottomNavigation.Model(3, R.drawable.ic_profil))
        navBar.setOnShowListener { item: MeowBottomNavigation.Model ->
            when (item.id) {
                1 -> {
                    loadFragment(this, HomeFragment(this), R.string.home_page_vedette)
                    return@setOnShowListener
                }
                2 -> {
                    loadFragment(this,CommandesFragment(this), R.string.commande_detail_page_title)
                    return@setOnShowListener
                }
                3 -> {
                    loadFragment(this,ProfileFragment(this), R.string.profile_page_title)
                    return@setOnShowListener
                }
            }
        }
        // default Fragment
        navBar.show(1, true)

        // pour éviter les erreurs
        navBar.setOnClickMenuListener { }
        navBar.setOnReselectListener { }
    }
}