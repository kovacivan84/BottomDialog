package com.kovacivan.bottomdialog

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kovacivan.bottomdialog.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		binding.button.setOnClickListener {
			val bottomDialog = BottomDialog(this, binding.root)
				.title("Do you want to delete or edit this item?")
				.topButtonText("Delete")
				.bottomButtonText("Edit")
				.cancelButtonText("Cancel")
				.showBottomDialog()

			bottomDialog.onItemClick = { buttonText ->
				when (buttonText) {
					"Delete" -> {
						Toast.makeText(
							this,
							"You clicked on DELETE button",
							Toast.LENGTH_SHORT
						).show()
					}
					"Edit" -> {
						Toast.makeText(
							this,
							"You clicked on EDIT button",
							Toast.LENGTH_SHORT
						).show()
					}
					"Cancel" -> {
						Toast.makeText(
							this,
							"You clicked on CANCEL button",
							Toast.LENGTH_SHORT
						).show()
					}
					else -> {
						// Should never happened
						Toast.makeText(
							this,
							"Something went wrong",
							Toast.LENGTH_SHORT
						).show()
					}
				}
			}
		}
	}
}