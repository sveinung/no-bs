define(function(require) {

    var _ = require('underscore'),
        template = require('text!./libraryView.mustache'),
        renderTemplate = require('base/renderTemplate'),
        AddBookView = require('./books/addBookView'),
        rivets = require('rivets');

    var LibraryView = function(options) {
        var el = options.el;
        var libraryRepository = options.libraryRepository;

        var getLibrary = function() {
            libraryRepository.getLibrary(options.libraryId).done(libraryReceived);
        };

        var libraryReceived = function(response) {
            rivets.bind(el.find('.books'), { books: response.books });
        };

        var addBookClicked = function(event) {
            event.preventDefault();

            el.find('.book-input-form').removeClass('hide');
            var addBookView = AddBookView({
                el: el.find('.book-input-form')
            });
            addBookView.render();
        };

        var render = function() {
            el.html(renderTemplate(template));

            el.find('.add-book').click(addBookClicked);

            getLibrary();
        };

        return {
            render: render
        }
    };

    return LibraryView;
});
