# BottomDialog

BottomDialog is an Android library that shows a slide-up animation dialog from the bottom of the screen. Something like on iOS. It is intended to be used for dialogs with yes/no/cancel answers. It is customizable so you can style it as you like.

## Screenshots!
<img src="https://user-images.githubusercontent.com/24279917/216639539-92f20335-e36c-45e2-9ecb-000a90f40d9d.gif" width="200"/>        <img src="https://user-images.githubusercontent.com/24279917/216639881-5347829a-d07c-41a5-b382-e9bd638e9a5c.gif" width="200"/>        <img src="https://user-images.githubusercontent.com/24279917/216640242-9d3c6e95-741f-4a84-9fcd-9c2b45b57e78.gif" width="200"/>        <img src="https://user-images.githubusercontent.com/24279917/216640356-bfac339a-e9ba-4114-a1af-e78e4f004ee8.gif" width="200"/>

## Usage

#### If you only want to see how it works:

```bash
BottomDialog(this, binding.root)
   .showBottomDialog()
```
   
#### Set button text:

```bash
BottomDialog(this, binding.root)
	.topButtonText("Delete")
	.bottomButtonText("Edit")
	.cancelButtonText("Cancel")
	.showBottomDialog()
```

#### And this is how you get a return from button clicks:

```bash
val bottomDialog = BottomDialog(this, binding.root)
	.topButtonText("Delete")
	.bottomButtonText("Edit")
	.cancelButtonText("Cancel")
	.showBottomDialog()

bottomDialog.onItemClick = { buttonText ->
        // Do your stuff here
}
```

#### Button click example:

```bash
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
```

## Limitations

Currently it's working only if you are adding bottom dialog to ConstraintLayout. I'm working on it to make it work on any layout type.

#### All options

| Option      | Description |
| ----------- | ----------- |
|animationDuration(Long) |	Set the duration of the animation in milliseconds|
|title(String) |	Set the text of the title|
|titleTextSize(Int) |	Change the text size for the title|
|titleTextColor(Int) |	Change title text color (eg. Color.RED)|
|titleTypeface(Int) |	Change title text Typeface (eg. Typeface.BOLD)|
|topButtonText(String) |	Set text for the top button|
|topButtonTextSize(Int) |	Change the size of the top button text|
|topButtonTextColor(Int) |	Change the color of the top button (eg. Color.RED)|
|topButtonTypeface(Int) |	Change top button text Typeface (eg. Typeface.BOLD)|
|hideTopButton(Boolean) |	Hide top button|
|bottomButtonText(String) |	Set text for the bottom button|
|bottomButtonTextSize(Int) |	Change the size of the bottom button text|
|bottomButtonTextColor(Int) |	Change the color of the bottom button (eg. Color.RED)|
|bottomButtonTypeface(Int) |	Change bottom button text Typeface (eg. Typeface.BOLD)|
|cancelButtonText(String) |	Set text for the cancel button|
|cancelButtonTextSize(Int) |	Change the size of the cancel button text|
|cancelButtonTextColor(Int) |	Change the color of the cancel button (eg. Color.RED)|
|cancelButtonTypeface(Int) |	Change cancel button text Typeface (eg. Typeface.BOLD)|
|backgroundOverlay(Boolean) |	Set a transparent overlay over your layout|
|backgroundOverlayTransparencyPercentage(Float) |	Set the percentage of background overlay transparency|
|backgroundOverlayColor(Int) |	Change the color of the overlay (eg. Color.RED)|
|hideOnBackgroundClick(Boolean) |	Hides bottom dialog on background click|
|showBottomDialog() |	Shows bottom dialog (MUST BE CALLED LAST)|

## License
Copyright Ivan Kovac

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
