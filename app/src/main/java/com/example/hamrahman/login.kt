package com.example.hamrahman

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val mediaPlayer: MediaPlayer = MediaPlayer.create(this,R.raw.zang)
        mediaPlayer.start()

        val txtview_net: TextView =findViewById(R.id.txtview_net)
        val btn_internet: ImageButton =findViewById(R.id.img_btn_internet)
        val btn_ent: ImageButton =findViewById(R.id.img_btn_enteghan)
        val btn_mad: ImageButton =findViewById(R.id.img_btn_madar)
        val btn_tar: ImageButton =findViewById(R.id.img_btn_tahha)
        val btn_logout: Button =findViewById(R.id.btn_exit)
        val btn_exit_net: Button =findViewById(R.id.btn_exit_net)

        val frm_asli: FrameLayout =findViewById(R.id.Fram_Asli)
        val frm_net: FrameLayout =findViewById(R.id.Fram_Internet)
        val frmview_net: FrameLayout =findViewById(R.id.Fram_ViewNet)
        val btn_net_1: Button =findViewById(R.id.btn_net_1)
        val btn_net_2: Button =findViewById(R.id.btn_net_2)
        val btn_net_3: Button =findViewById(R.id.btn_net_3)
        val txtview_pol: TextView =findViewById(R.id.txtview_pol)
        val txtview_mande: TextView =findViewById(R.id.txtview_mande)

        val txtview_mobile: TextView =findViewById(R.id.txtview_mobile)
        if(intent.extras!=null) {
            var view_phone: String = intent.extras!!.getString("Edit_Phone", "")
            txtview_mobile.text = "" + view_phone
        }

        setStateLogin(this, true)

        btn_logout.setOnClickListener {
            setStateLogin(this, false)
            var intent: Intent = Intent(this,MainActivity::class.java)
            finish()
            startActivity(intent)
            mediaPlayer.start()
        }
        btn_ent.setOnClickListener {
            mediaPlayer.start()
            Toast.makeText(this, "این طرح در حال حاضر فعال نمیباشد", Toast.LENGTH_SHORT).show()

        }
        btn_mad.setOnClickListener {
            mediaPlayer.start()
            Toast.makeText(this, "این طرح در حال حاضر فعال نمیباشد", Toast.LENGTH_SHORT).show()
        }
        btn_tar.setOnClickListener {
            mediaPlayer.start()
            Toast.makeText(this, "این طرح در حال حاضر فعال نمیباشد", Toast.LENGTH_SHORT).show()
        }
        btn_internet.setOnClickListener {
            mediaPlayer.start()
            frm_asli.visibility= View.GONE
            frm_net.visibility= View.VISIBLE
        }

        btn_exit_net.setOnClickListener {
            mediaPlayer.start()
            frm_asli.visibility= View.VISIBLE
            frm_net.visibility= View.GONE
        }

        btn_net_1.setOnClickListener {
            val builder= AlertDialog.Builder(this)
            builder.setTitle("توجه")
            builder.setIcon(android.R.drawable.ic_dialog_info)
            builder.setMessage("آیا از خرید بسته مطمئن هستین؟")

            builder.setPositiveButton("بله"){dialog,which->
                mediaPlayer.start()
                Toast.makeText(this, "بسته با موفقیت خرید شد", Toast.LENGTH_SHORT).show()

                frmview_net.visibility= View.VISIBLE
                txtview_net.text="مانده 1000 مگ"
                txtview_pol.text="195,000 ریال"
                txtview_mande.text="100 %"
            }
            builder.setNegativeButton("خیر"){dialog,which->
            }
            builder.setCancelable(false)
            builder.show()

        }
        btn_net_2.setOnClickListener {
            val builder= AlertDialog.Builder(this)
            builder.setTitle("توجه")
            builder.setIcon(android.R.drawable.ic_dialog_info)
            builder.setMessage("آیا از خرید بسته مطمئن هستین؟")

            builder.setPositiveButton("بله"){dialog,which->
                mediaPlayer.start()
                Toast.makeText(this, "بسته با موفقیت خرید شد", Toast.LENGTH_SHORT).show()

                frmview_net.visibility= View.VISIBLE
                txtview_net.text="مانده 20 گیگ"
                txtview_pol.text="0 ریال"
                txtview_mande.text="100 %"
            }
            builder.setNegativeButton("خیر"){dialog,which->
            }
            builder.setCancelable(false)
            builder.show()
        }
        btn_net_3.setOnClickListener {
            mediaPlayer.start()
            val builder= AlertDialog.Builder(this)
            builder.setTitle("توجه!!!")
            builder.setIcon(android.R.drawable.ic_dialog_info)
            builder.setMessage("آیا از خرید بسته مطمئن هستین؟")
            builder.setPositiveButton("باشه"){dialog,which->
                Toast.makeText(this, "موجودی کافی نیست", Toast.LENGTH_SHORT).show()
            }
            builder.setNegativeButton("خیر"){dialog,which->
            }
            builder.setCancelable(false)
            builder.show()
        }

    }

    private fun setStateLogin(context: Context, state: Boolean) {
        val sharedPreferences: SharedPreferences = getSharedPreferences("login_pref", Context.MODE_PRIVATE)
        var editor = sharedPreferences.edit()
        editor.putBoolean("state",state)
        editor.apply()

    }
}