package android.nod.de_mobile_lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var editTextAndroidVer: EditText
    private lateinit var editTextCodeName: EditText
    private lateinit var btnAdd: Button
    private lateinit var tableLayoutView: TableLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()


        btnAdd.setOnClickListener {
            when (it!!.id) {
                R.id.btnAdd -> {
                    if (validateForm()) {
                        //creating table row
                        val tableRow = TableRow(applicationContext)

                        //table row property
                        tableRow.setBackgroundColor(getColor(R.color.purple_500))

                        //table row initializes with layout param
                        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
                        tableRow.layoutParams = layoutParams

                        //Creating view dynamically to add into table row -> first column view
                        val andVersion = TextView(this)
                        andVersion.width = getWidthOfScreen() / 2
                        andVersion.setPadding(20, 20, 20, 20)
                        andVersion.setTextColor(getColor(R.color.white))
                        andVersion.text = editTextAndroidVer.text.toString()

                        ////Creating view dynamically to add into table row -> second column view
                        val code = TextView(this)
                        code.width = getWidthOfScreen() / 2
                        code.setPadding(20, 20, 20, 20)
                        code.setTextColor(getColor(R.color.white))
                        code.text = editTextCodeName.text.toString()

                        //adding 2 created view to the table row
                        tableRow.addView(andVersion)
                        tableRow.addView(code)

                        //adding table row to the table
                        tableLayoutView.addView(tableRow)

                        //after adding value to the table row, clearing the above edit text
                        editTextAndroidVer.text.clear()
                        editTextCodeName.text.clear()

                    }
                }
            }
        }

    }

    private fun validateForm(): Boolean {
        if (editTextAndroidVer.text.isEmpty()) {
            editTextAndroidVer.error = "Android Version field can not be empty."
            editTextAndroidVer.requestFocus()
            return false
        } else if (editTextCodeName.text.isEmpty()) {
            editTextCodeName.error = "Code Name field can not be empty."
            editTextCodeName.requestFocus()
            return false
        }
        return true
    }

    private fun getWidthOfScreen(): Int {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics.widthPixels
    }

    fun init() {
        editTextAndroidVer = findViewById(R.id.editTextAndroidVer)
        editTextCodeName = findViewById(R.id.editTextCodeName)
        btnAdd = findViewById(R.id.btnAdd)
        tableLayoutView = findViewById(R.id.tableLayoutView)
    }

}