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
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val etRegisterEmail: EditText = view.findViewById(R.id.et_register_email)
        val etRegisterPw: EditText = view.findViewById(R.id.et_register_pw)
        val btnRegister: Button = view.findViewById(R.id.btn_register)
        val btnToLogin: Button = view.findViewById(R.id.btn_to_login)

        btnRegister.setOnClickListener {
            val email: String = etRegisterEmail.text.toString()
            val pw: String = etRegisterPw.text.toString()

            val dbHelper = MyDBHelper(MainActivity().applicationContext)
            val db = dbHelper.writableDatabase
            val insertStatement: String = "INSERT INTO USER (email, pw) VALUES ($email, $pw);"
            db.execSQL(insertStatement)
            Snackbar.make(view, "Registrierung erfolgreich!", Snackbar.LENGTH_SHORT).show()
        }

        btnToLogin.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragment_container, LoginFragment())
            }
        }
    }

}