### Dagger 2, screens Subcomponents sample.

The sample based on article [Dagger 2. Subcomponents. Best practice](https://habrahabr.ru/post/334710/)


### Short description

We have main AppComponent, common for all screens and own subcomponent for every screen.
A screen subcomponent module contains dependencies useless for other screens. So we hold on the screen subcomponent as long as the screen is "alive".

In this example we freed our fragment from the excess logic - the adapter creating. And we freed adapter from the listener holding simply by pass the listener directly to the factory constructor.
