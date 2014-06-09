define(function(require) {

    var sinon = require('sinon');

    var addBookViewPageObject = require('modules/library/books/addBookViewPageObject');

    return function libraryViewPageObject($el) {
        return {
            clickAddBook: function(done) {
                var server = sinon.fakeServer.create();

                var genresResponse = [
                    { name: "Crime novel" },
                    { name: "Picaresco" }
                ];

                $el.find(".add-book").click();

                server.respondWith([200, { "Content-Type": "application/json" }, JSON.stringify(genresResponse)]);
                server.respond();
                server.restore();

                done(addBookViewPageObject($el.find('.add-book-view')));

                return this;
            },
            expectToHaveNumberOfBooks: function(expectedNumberOfBooks) {
                expect($el.find(".books li").size()).toBe(expectedNumberOfBooks);
                return this;
            }
        };
    };
});
