package com.android.database

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val etLoginEmail: EditText = view.findViewById(R.id.et_login_email)
        val etLoginPw: EditText = view.findViewById(R.id.et_login_pw)
        val btnLogin: Button = view.findViewById(R.id.btn_login)
        val btnToRegistration: Button = view.findViewById(R.id.btn_to_registration)

        btnLogin.setOnClickListener {
            val email: String = etLoginEmail.text.toString()
            val pw: String = etLoginPw.text.toString()

            val dbHelper = MyDBHelper(MainActivity().applicationContext)
            val db = dbHelper.readableDatabase
            val queryStatement: String = "SELECT ID FROM USER WHERE email='$email' and pw='$pw'"
            val results = db.rawQuery(queryStatement, null)

            if (results.count > 0) {
                Snackbar.make(it, "Login erfolgreich!", Snackbar.LENGTH_SHORT).show()
            } else {
                Snackbar.make(it, "Falsche / Nicht Vorhandene Daten", Snackbar.LENGTH_SHORT).show()
            }

        }

        btnToRegistration.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragment_container, RegisterFragment())
            }
        }

    }
}