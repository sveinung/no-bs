Example app that uses Page Objects
==================================

[Read the blog post about Page Objects](https://github.com/sveinung/writings/blob/gh-pages/maintainable_backbone_tests.md)

Setup
-----

Install [Gradle](http://www.gradle.org/) and [Node.js](http://nodejs.org/).

Run `npm install`.

Running and testing the app
---------------------------

Run the app with `gradle run`.

Run the JavaScript tests with `./make.js test` or `node make.js test`.

Page object examples
--------------------

[libraryViewSpec](https://github.com/sveinung/pageobject-example/blob/master/src/main/webapp/modules/library/libraryViewSpec.js) using [libraryViewPageObject](https://github.com/sveinung/pageobject-example/blob/master/src/main/webapp/modules/library/libraryViewPageObject.js)

[addBookViewSpec](https://github.com/sveinung/pageobject-example/blob/master/src/main/webapp/modules/library/books/addBookViewSpec.js) using [addBookViewPageObject](https://github.com/sveinung/pageobject-example/blob/master/src/main/webapp/modules/library/books/addBookViewPageObject.js)
