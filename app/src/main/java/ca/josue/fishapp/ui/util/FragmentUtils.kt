package ca.josue.fishapp.ui.util

import android.widget.TextView
import androidx.fragment.app.Fragment
import ca.josue.fishapp.R
import ca.josue.fishapp.ui.MainActivity

class FragmentUtils {
    companion object{
        /**
         * Méthode qui permet de changer les fragments
         * @param fragment le fragment à replacer
         * @param titlePage l'identifiant de la textView qui fait reference au nom de la page
         * */
        fun loadFragment(context: MainActivity, fragment: Fragment, titlePage: Int) {

            // actualiser le titre de la page
            context.findViewById<TextView>(R.id.page_title).text = context.resources.getString(titlePage)

            // injecter le fragment dans notre boite
            val transaction = context.supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.addToBackStack(null) // annuler le retour vers ce composant
            transaction.commit()
        }
    }
}