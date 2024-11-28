 
● activity_main.xml 
 
<?xml version="1.0" encoding="utf-8"?> 
<LinearLayout 
    xmlns:android="http://schemas.android.com/apk/res/android"     android:layout_width="match_parent"     android:layout_height="match_parent"     android:orientation="vertical"     android:padding="16dp" 
    android:background="#F5F5F5"> 
 
    <TextView         android:layout_marginTop="20dp"         android:id="@+id/textView1"         android:layout_width="match_parent"         android:layout_height="wrap_content"         android:padding="12dp"         android:text="@string/label_one"         android:textSize="18sp"         android:textColor="#424242" 
        android:layout_marginBottom="8dp" /> 
 
    <TextView         android:id="@+id/textView2"         android:layout_width="match_parent"         android:layout_height="wrap_content"         android:padding="12dp"         android:text="@string/label_two"         android:textSize="18sp"         android:textColor="#424242" 
        android:layout_marginBottom="8dp" /> 
 
    <TextView         android:id="@+id/textView3"         android:layout_width="match_parent"         android:layout_height="wrap_content"         android:padding="12dp"         android:text="@string/label_three"         android:textSize="18sp"         android:textColor="#424242" 
        android:layout_marginBottom="8dp" /> 
 
    <TextView         android:id="@+id/textView4"         android:layout_width="match_parent"         android:layout_height="wrap_content"         android:padding="12dp"         android:text="@string/label_four"         android:textSize="18sp"         android:textColor="#424242" 
        android:layout_marginBottom="8dp" /> 
 
    <TextView         android:id="@+id/textView5"         android:layout_width="match_parent"         android:layout_height="wrap_content"         android:padding="12dp"         android:text="@string/label_five"         android:textSize="18sp"         android:textColor="#424242" 
        android:layout_marginBottom="24dp" /> 
 
    <Button         android:id="@+id/buttonNavigate"         android:layout_width="match_parent"         android:layout_height="62dp"         android:backgroundTint="#680A51"         android:text="Go to Screen Two"         android:textColor="#FFFFFF"         android:textSize="20sp" /> 
</LinearLayout> 
 
● activity_second.xml 
 
<?xml version="1.0" encoding="utf-8"?> 
<LinearLayout 
    xmlns:android="http://schemas.android.com/apk/res/android"     android:layout_width="match_parent"     android:layout_height="match_parent"     android:orientation="vertical"     android:padding="16dp" 
    android:background="#DED0EB"> 
 
    <TextView         android:id="@+id/textViewData"         android:layout_marginTop="30dp"         android:layout_width="match_parent"         android:layout_height="wrap_content"         android:padding="16dp"         android:textSize="18sp"         android:textColor="#424242"         android:layout_marginBottom="24dp" 
        android:background="#FFFFFF" /> 
 
    <Button         android:id="@+id/buttonNext"         android:layout_width="309dp"         android:layout_height="65dp"         android:layout_gravity="center"         android:backgroundTint="#C10E70"         android:text="Go to Screen Three"         android:textColor="#FFFFFF" 
        android:textSize="20sp" /> 
</LinearLayout> 
 
● activity_third.xml 
 
<?xml version="1.0" encoding="utf-8"?> 
<LinearLayout     xmlns:android="http://schemas.android.com/apk/res/android"     android:layout_width="match_parent"     android:layout_height="match_parent"     android:orientation="vertical"     android:padding="16dp" 
    android:background="#F4DDDD"> 
 
    <TextView 
        android:id="@+id/finalTextView"         android:layout_marginTop="30dp"         android:layout_width="match_parent"         android:layout_height="wrap_content"         android:padding="16dp"         android:textSize="20sp"         android:textColor="#424242"         android:background="#FFFFFF" /> 
</LinearLayout> 
 
● MainActivity.kt 
 
package com.example.assignment3 
 
import android.content.Intent import android.os.Bundle import android.widget.Button import androidx.activity.enableEdgeToEdge import androidx.appcompat.app.AppCompatActivity import androidx.core.view.ViewCompat 
import androidx.core.view.WindowInsetsCompat 
 
class MainActivity : AppCompatActivity() {     override fun onCreate(savedInstanceState: Bundle?) {         super.onCreate(savedInstanceState)         setContentView(R.layout.activity_main)         val buttonNavigate: Button = findViewById(R.id.buttonNavigate) 
 
        buttonNavigate.setOnClickListener {             // Passing data to SecondActivity             val intent = Intent(this, SecondActivity::class.java)             intent.putExtra("string1", getString(R.string.label_one))             intent.putExtra("string2", getString(R.string.label_two))             intent.putExtra("string3", getString(R.string.label_three))             intent.putExtra("string4", getString(R.string.label_four))             intent.putExtra("string5", getString(R.string.label_five))             intent.putExtra("booleanValue", true)             intent.putExtra("intValue", 42)             intent.putExtra("floatValue", 3.14f) 
            startActivity(intent) 
        } 
    } 
} 
 
● SecondActivity.kt 
 
package com.example.assignment3 
 
import android.content.Intent import android.os.Bundle import android.util.Log import android.widget.Button import android.widget.TextView import androidx.activity.enableEdgeToEdge import androidx.appcompat.app.AppCompatActivity import androidx.core.view.ViewCompat 
import androidx.core.view.WindowInsetsCompat 
 
class SecondActivity : AppCompatActivity() {     override fun onCreate(savedInstanceState: Bundle?) {         super.onCreate(savedInstanceState)         setContentView(R.layout.activity_second)         val textViewData: TextView = findViewById(R.id.textViewData)         val buttonNext: Button = findViewById(R.id.buttonNext) 
 
        // Retrieve data from intent         val string1 = intent.getStringExtra("string1")         val string2 = intent.getStringExtra("string2")         val string3 = intent.getStringExtra("string3")         val string4 = intent.getStringExtra("string4")         val string5 = intent.getStringExtra("string5")         val booleanValue = intent.getBooleanExtra("booleanValue", false) 
        val intValue = intent.getIntExtra("intValue", 0) 
        val floatValue = intent.getFloatExtra("floatValue", 0.0f) 
 
        // Combine data into one string 
        val data = """             $string1 
            $string2 
            $string3 
            $string4 
            $string5 
            Boolean: $booleanValue 
            Integer: $intValue             Float: $floatValue 
        """.trimIndent() 
 
        textViewData.text = data 
        Log.d("SecondActivity", data) 
 
        buttonNext.setOnClickListener {             val finalData = "Final Data: $data"             val intent = Intent(this, ThirdActivity::class.java)             intent.putExtra("finalData", finalData) 
            startActivity(intent) 
        } 
    } 
} 
 
● ThirdActivity.kt 
 
package com.example.assignment3 
 
import android.os.Bundle import android.widget.TextView import androidx.activity.enableEdgeToEdge import androidx.appcompat.app.AppCompatActivity import androidx.core.view.ViewCompat 
import androidx.core.view.WindowInsetsCompat 
 
class ThirdActivity : AppCompatActivity() {     override fun onCreate(savedInstanceState: Bundle?) {         super.onCreate(savedInstanceState)         setContentView(R.layout.activity_third)         val finalTextView: TextView = findViewById(R.id.finalTextView) 
 
        val finalData = intent.getStringExtra("finalData")         finalTextView.text = finalData 
    } 
} 
● strings.xml 
<resources> 
    <string name="app_name">Exploring Kotlin</string> 
    <string name="label_one">Welcome to MainActivity!</string> 
    <string name="label_two">Explore Android Development Knowledge.</string> 
    <string name="label_three">Beautiful Interfaces.</string> 
    <string name="label_four">Kotlin is Fun!!!</string> 
    <string name="label_five">Start Your Journey Today!!!</string> </resources> 
