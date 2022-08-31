# redditApiApp
Repository of Reddit API Application

The Top Reddits reader application shows a list of reddits to the user with the title and thumbnail on the first screen. If you click in any reddit, it navigates to a
second screen where you found more information about the reddit, including title, image, author, score, and number of comments. The application uses connection to an
API to obtain the list of reddits.

The app have the MVVM architecture and uses Koin to do the dependency injection. The View is composed of a main activity that hosts two fragments, using navigation
with safe args to pass the data between the fragments. The first fragment shows the list through a RecyclerView, using an Adapter and a ViewHolder. The user can pull
up to refresh reddits. Also, if you reach the end of the list, it makes another call to the API to load more reddits for the user, having a load icon to show while the
user waits the connection to be completed.

The ViewModel is responsible with the navigation, the click listeners and connecting to the repository to get the reddits that are shown. The repository connects to
the API and to a local database. The API call uses Retrofit while the local database uses Room. The local database saves the last reddits you obtained from the API
call to implement the Offline mode, showing the last reddits the user saw when he had internet.

The application has 3 models, on for the API, one for the local database, and one domain model, to be used during the application. The application has support for
different device resolutions and orientation.

This idea of the application comes from an Android Code Challenge and uses the Reddit API: https://www.reddit.com/top.json.
