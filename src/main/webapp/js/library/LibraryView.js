var LibraryView = (function(_, $) {
    var LibraryView = function(options) {
        this.el = options.el;
        this.el.find(".retrieve-books").click(_.bind(this.getLibrary, this));
    };

    _.extend(LibraryView.prototype, {
        getLibrary: function() {
            $.ajax('http://localhost:8080/library/2', {
                accepts: {
                    json: 'application/json'
                }
            }).done(_.bind(this.libraryReceived, this));
        },

        libraryReceived: function(response) {
            this.el.find(".books").empty();

            _.each(response.books, function(book) {
                this.el.find(".books").append("<li>" + book + "</li>");
            }, this);
        }
    });

    return LibraryView;
}(_, jQuery));