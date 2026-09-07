# Practical-6: Frame-by-Frame Animation and Splash Screen

## Aim
To create an Android application that demonstrates **Frame-by-Frame Animation** and a **Splash Screen with Twin Animation** using Android animation APIs and resources.

## Tools Required
- Android Studio
- Android SDK
- Kotlin
- Android Emulator or Android device
- SVG/XML animation resources

## Practical Objectives

### 6.1 Study Frame-by-Frame Animation
**Frame-by-Frame Animation** displays a sequence of different images one after another to create the appearance of movement.

In Android, frame-by-frame animation can be implemented using `AnimationDrawable` and an `<animation-list>` resource.

Example:

```xml
<animation-list
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:oneshot="false">

    <item
        android:drawable="@drawable/frame1"
        android:duration="100" />

    <item
        android:drawable="@drawable/frame2"
        android:duration="100" />

</animation-list>
```

The individual images are displayed sequentially to produce an animation.

### 6.2 Study Twin Animation
**Twin Animation**, also known as **Tween Animation**, changes the appearance or position of an existing View over a period of time.

Android provides different tween animation types:

- Scale Animation
- Translate Animation
- Rotate Animation
- Alpha Animation

These animations can be combined using the `<set>` tag.

## 6.3 Create MainActivity

Create `MainActivity` according to the given UI design.

The Activity should demonstrate the **frame-by-frame animation** using a sequence of images.

The sequence of images provided for the practical can be used for:
- Alarm animation
- Heart animation
- Other required frame animations

## 6.4 Create SplashActivity

Create a separate `SplashActivity` that appears when the application starts.

The Splash Screen should demonstrate **twin/tween animation** using Android animation resources.

The SplashActivity can contain:
- Application logo
- Animated logo or image
- Gradient background
- Scale, translate, rotate, and alpha animations

## 6.5 Create Gradient Rectangle

Create a gradient rectangle as the background of the SplashActivity using the `<gradient>` tag inside a `<shape>` tag.

Required properties:

- **Shape:** Rectangle
- **Gradient type:** Radial
- **Center X:** `0.9`
- **Center Y:** `0.9`
- **Radius:** `1500`
- **Start Color:** Pink
- **End Color:** Blue

Example structure:

```xml
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">

    <gradient
        android:type="radial"
        android:centerX="0.9"
        android:centerY="0.9"
        android:gradientRadius="1500"
        android:startColor="#..."
        android:endColor="#..." />

</shape>
```

## 6.6 Animation Resources

Create an `anim` folder inside the `res` directory:

```text
app
└── src
    └── main
        └── res
            └── anim
```

The `anim` folder is used to store XML animation resources.

The practical requires the following animation elements:

- `<set>`
- `<scale>`
- `<translate>`
- `<rotate>`
- `<alpha>`
- `android:startOffset`
- `android:duration`

### `<set>` Tag
The `<set>` tag is used to combine multiple animations and execute them together or sequentially.

### `<scale>` Tag
Used to increase or decrease the size of a View.

### `<translate>` Tag
Used to move a View from one position to another.

### `<rotate>` Tag
Used to rotate a View around a specified point.

### `<alpha>` Tag
Used to change the transparency of a View.

### `startOffset`
Specifies the delay before an animation starts.

Example:

```xml
android:startOffset="100"
```

### `duration`
Specifies how long the animation should run.

Example:

```xml
android:duration="1000"
```

## 6.7 AnimationDrawable

`AnimationDrawable` is used to control frame-by-frame animations defined using an `<animation-list>` resource.

Example:

```kotlin
val animationDrawable =
    imageView.drawable as AnimationDrawable

animationDrawable.start()
```

The animation can be stopped using:

```kotlin
animationDrawable.stop()
```

## 6.8 AnimationUtils

`AnimationUtils` is an Android utility class used to load animation resources.

Example:

```kotlin
val animation = AnimationUtils.loadAnimation(
    this,
    R.anim.animation
)
```

### `loadAnimation()`
The `loadAnimation()` method loads an animation XML resource from the `res/anim` directory.

## 6.9 Animation Listener

An animation listener can be used to detect different animation events.

The commonly used methods are:

- `onAnimationStart()`
- `onAnimationEnd()`
- `onAnimationRepeat()`

Example:

```kotlin
animation.setAnimationListener(object : Animation.AnimationListener {

    override fun onAnimationStart(animation: Animation?) {
    }

    override fun onAnimationEnd(animation: Animation?) {
    }

    override fun onAnimationRepeat(animation: Animation?) {
    }
})
```

## 6.10 onWindowFocusChanged()

`onWindowFocusChanged()` is an Activity callback method that is called when the Activity window gains or loses focus.

It can be used to start the frame animation after the Activity becomes visible.

Example:

```kotlin
override fun onWindowFocusChanged(hasFocus: Boolean) {
    super.onWindowFocusChanged(hasFocus)

    if (hasFocus) {
        // Start animation
    }
}
```

## 6.11 Immersive Mode

**Immersive Mode** allows an application to provide a more immersive full-screen experience by hiding system UI elements such as the status bar and navigation controls when appropriate.

It is commonly used in applications such as:
- Games
- Video players
- Image viewers

## 6.12 Edge-to-Edge Content Display

**Edge-to-edge** allows application content to extend behind the system bars and use the full screen area.

This can provide a modern full-screen layout where the application content reaches the edges of the device display.

The application should handle system bar insets appropriately so that important UI elements are not hidden behind system bars.

## 6.13 overridePendingTransition()

`overridePendingTransition()` can be used to specify custom enter and exit animations when switching between Activities.

Example:

```kotlin
overridePendingTransition(
    R.anim.slide_in,
    R.anim.slide_out
)
```

It can be used to create a smooth transition from `SplashActivity` to `MainActivity`.

## 6.14 finish()

The `finish()` method closes the current Activity.

For a Splash Screen, it can be used after launching `MainActivity` so that the user cannot return to the SplashActivity using the Back button.

Example:

```kotlin
startActivity(Intent(this, MainActivity::class.java))
finish()
```

## 6.15 Convert SVG File to XML

The animation images and logo may be provided as SVG files.

Android Studio can convert/import vector graphics into Android Vector Drawable XML resources.

These drawable XML files can then be placed in the `res/drawable` directory and used through resource IDs such as:

```kotlin
R.drawable.logo
```

## Required Animation Resources

The project should demonstrate the following concepts:

| Resource / Concept | Purpose |
|---|---|
| `animation-list` | Defines frame-by-frame animation |
| `AnimationDrawable` | Controls frame animation |
| `<set>` | Combines multiple animations |
| `<scale>` | Changes size |
| `<translate>` | Moves a View |
| `<rotate>` | Rotates a View |
| `<alpha>` | Changes transparency |
| `startOffset` | Delays animation start |
| `duration` | Defines animation duration |
| `AnimationUtils` | Loads animation XML |
| `loadAnimation()` | Loads an animation resource |
| `setAnimationListener()` | Handles animation events |
| `onWindowFocusChanged()` | Detects window focus |
| `overridePendingTransition()` | Applies Activity transition |
| `finish()` | Closes the current Activity |

## Expected Learning Outcomes

After completing this practical, the student will be able to:

1. Understand the concept of Frame-by-Frame Animation.
2. Understand Tween/Twin Animation.
3. Implement frame animation using `AnimationDrawable`.
4. Create an `<animation-list>` resource.
5. Create and configure a SplashActivity.
6. Create a gradient background using `<shape>` and `<gradient>`.
7. Implement radial gradients.
8. Use Scale, Translate, Rotate, and Alpha animations.
9. Combine animations using the `<set>` tag.
10. Use `AnimationUtils` and `loadAnimation()`.
11. Handle animation events using an animation listener.
12. Understand the purpose of `onWindowFocusChanged()`.
13. Implement Activity transition animations.
14. Understand immersive mode and edge-to-edge content.
15. Add and use drawable/vector resources in an Android project.

## Conclusion

This practical demonstrates Android animation concepts by implementing **Frame-by-Frame Animation** and **Tween Animation** with a Splash Screen. It provides hands-on experience with `AnimationDrawable`, animation XML resources, `AnimationUtils`, animation listeners, gradient backgrounds, Activity transitions, immersive mode, and edge-to-edge content display.
