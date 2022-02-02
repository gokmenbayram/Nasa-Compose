# Nasa-Compose

This application contains images of three different Mars vehicles along with the API provided by [NASA](https://api.nasa.gov/). It is mainly developed using Jetpack Compose and clean architecture.

Link to the [App Architecture](https://developer.android.com/jetpack/guide)

## Base Structure

- **Presentation Layer(UI Layer):** You build these elements using Views or Jetpack Compose functions. State holders (such as ViewModel classes) that hold data, expose it to the UI, and handle logic.

- **Data Layer:** The data layer of an contains the business logic. (Data Source, Repository etc.)

> **Note:** You can put the domain layer between the Presentation layer and the Data layer.

- **Di:** Contains related modules for dependency injection.

- **Service:** It contains the network services for the api.

- **Db:** Contains local database services.


## Screenshots
![Screen Shot 2022-02-02 at 10 30 47](https://user-images.githubusercontent.com/28503591/152111889-690f80ba-ae5f-4e1d-a78d-c127c18541ad.png)
![Screen Shot 2022-02-02 at 10 30 20](https://user-images.githubusercontent.com/28503591/152111822-24f2233c-0253-476c-8ba5-f08dc4bde2b7.png)
![Screen Shot 2022-02-02 at 10 29 51](https://user-images.githubusercontent.com/28503591/152111769-6f5c2016-9674-49f6-810d-b7d4553c1619.png)


## Main Features 🕹

- 100% Kotlin-only.
- Following Clean Architecture approach.
- Following MVVM Architectural Design Pattern.
- Paging
- Dagger(Hilt)
- Retrofit2
- Room
- Coroutine
- Coil

## Note
- IF THE "API KEY" HAS EXPIRED YOU HAVE TO GENERATE A NEW KEY FROM [NASA](https://api.nasa.gov/) . AND YOU HAVE TO CHANGE THIS NEW KEY FROM *build.gradle(app)*.

## Contributing 🤝
- Feel free to open a issue or submit a pull request for any bugs/improvements.
