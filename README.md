# My ANTLR4 Project

## Description
This project demonstrates the use of ANTLR4 for parsing and lexical analysis. It includes an example ANTLR4 grammar (`SqlLexer.g4`) and a basic Java application to utilize the generated parser/lexer.

## Getting Started

### Prerequisites
To build and run this project, you will need:
*   **Java Development Kit (JDK)**: Version 8 or higher.
*   **Apache Maven**: Version 3.6.0 or higher.

### Installation
1.  **Clone the repository**:
    ```bash
    git clone [https://github.com/AlayhamTaha543/sqlInterpreter.git]
    cd my-antlr-project
    ```


### Building the Project
To compile the project and generate the ANTLR4 parser/lexer classes, run the following Maven command from the project root directory:
```bash
mvn clean install
```
This command will:
1.  Compile the Java source files.
2.  Process ANTLR4 grammars to generate `SqlLexerLexer.java` and `SqlLexerParser.java` (and other related files) into `target/generated-sources/antlr4/com/example/antlr4`.
3.  Package the project into a JAR file.

## Adding ANTLR4 Grammars
To add new ANTLR4 grammars to this project:
1.  Create your new grammar (e.g., `keywords`).
    ```
    my-antlr-project/
    ├── antlr4/
    │   ├── SqlLexer.g4
    ├── pom.xml
    └── src/
        └── main/java/com/example/App.java
    ```
3.  After adding a new grammar, run `mvn clean install` again to generate the corresponding Java lexer and parser classes. These classes will be generated in `target/generated-sources/antlr4/com/example/antlr4`.

## Usage
The `App.java` file provides a basic example of how to use the generated ANTLR4 lexer and parser. You can extend this application or create new classes to work with your grammars.

To run the example application:
```bash
mvn exec:java -Dexec.mainClass="com.example.App"
```

## Contributing
Feel free to contribute to this project by submitting issues or pull requests.
