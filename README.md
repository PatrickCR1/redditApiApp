# <p align="center">Reddit API Application </p>

# Reddit Api Application
### The Top Reddits reader application shows a list of reddits to the user with the title and thumbnail on the first screen. If you click in any reddit, it navigates to a second screen where you found more information about the reddit, including title, image, author, score, and number of comments. The application uses connection to an API to obtain the list of reddits.

# :hammer: Project Features
### The app have the MVVM architecture and uses Koin to do the dependency injection. The View is composed of a main activity that hosts two fragments, using navigation with safe args to pass the data between the fragments. The first fragment shows the list through a RecyclerView, using an Adapter and a ViewHolder. The user can pull up to refresh reddits. Also, if you reach the end of the list, it makes another call to the API to load more reddits for the user, having a load icon to show while the user waits the connection to be completed.

### The ViewModel is responsible with the navigation, the click listeners and connecting to the repository to get the reddits that are shown. The repository connects to the API and to a local database. The API call uses Retrofit while the local database uses Room. The local database saves the last reddits you obtained from the API call to implement the Offline mode, showing the last reddits the user saw when he had internet.

### The application has 3 models, on for the API, one for the local database, and one domain model, to be used during the application. The application has support for different device resolutions and orientation.

<img src="https://github.com/PatrickCR1/redditApiApp/blob/Main/Image/RedditApp.gif" width="240" height="450" />

# Tecnology applied:
### `Kotlin`
### `Android Studio`
### `Object-oriented programming`
### `MVVM Architecture`

# Resources:

### `Constraint Layout`: Feature to make the screen and components.
### `Jetpack Navigation`: Navigation between fragments.
### `Safe Args`: Sharing information between fragments.
### `Picasso`: Load images from internet.
### `Room:`: Data persistence: store data.
### `Retrofit:`: Make calls to an API, to get data and information needed to run the application.
### `Hearthstone Public API`: To get cards informations.
### `Koin`: Dependency Injection
### `Recycler View`: Feature to make lists.

## Dependencies

### You can [access the project dependencies here](https://github.com/PatrickCR1/redditApiApp/blob/Main/Dependencies.txt).

## 📁 Access the project
### You can [acess the source code from the project](https://github.com/PatrickCR1/redditApiApp/tree/Main) ou [download it](https://github.com/PatrickCR1/redditApiApp/archive/refs/heads/Main.zip).

## 🛠️ Open and Run the project

After downloading the project, you can open it with Android Studio. To do that, on the launcher screen click in:

- **Open an Existing Project** (or similar option)

- Search where the project files are and select it (In case of zip download, you will need to extract it before searching).
- Then, click ok.

The Android Studio should execute some tasks from Gradle to configure the project, wait until it finishs. When it does, you can run the App.

# Author
[<img src="https://avatars.githubusercontent.com/u/86331226?v=4" width=115><br><sub>Patrick Contarini Richard</sub>](https://github.com/PatrickCR1) 
