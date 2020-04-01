# Demonstration of Fetching all System Properties as Spring Bean

I created this project by the following steps:

* Went to https://start.spring.io/ and select Java 8, Spring 2.2.6, "Gradle", no additional dependencies.
* Modified the single `.java` file to define a bean, get it as the argument to a constructor, and log its content.

If the `main()` is empty, I assume that Spring's initialization sequence won't take place.