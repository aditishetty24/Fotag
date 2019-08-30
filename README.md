## Android Application: Fotag - Photo Rating App

### Functionalities:

**Custom ToolBar** [From Left to Right]:
Clear All Images, Load 10 Images, Rating Filter, Reset Button to clear the Rating Filter

The Clear All Images button will remove all the images and clear the Rating Filter on the toolbar.

Clicking on Load will load 10 images (.png, .jpeg, and .jpg files). After clicking the Load button for the first time, it is disabled and darkened. It will be enabled once the Clear All Images button is pressed.

Since the default orientation is Portrait, the images are displayed in a list (1 column) with scrolling enabled.

In the Rating Filter, clicking on the first star will display images with Rating >= 1. Clicking on the second star will display images with Rating >= 2.

If you want to filter by 5, you do not need to click each star. If you click the 5th star directly, it will display images with Rating = 5.

The reset button at the end will clear the Rating Filter and display all images.

Do not clear or change ratings of any image when images are displayed filtered (i.e. Rating Filter is not cleared/ when there is a filter on)

In the Rating for each Image, clicking on the first star will set Rating for that image as 1 and so on and so forth.
The X button below the Rating Bar for each image will clear the Rating for that image.

When rotating the phone, the orientation is now Horizontal. The grid now has 2 columns with scrolling enabled and the Ratings of the images, the Rating of the Filter on the toolbar, and the displayed images will remain the same from Portrait Mode.


**Before app loads, there might be a Dialog Box saying Google Play is not working, just click on close app.**

### Bugs: 
1. Clicking on the picture should enlarge it

### Features to be added:
1. Upload pictures from device
 
### Development Environment:

Android Studio 3.1.3
AVD: Pixel, Android 8.0 (Oreo, API 26)

macOS Mojave - Version 10.14.5

