var LibraryView = (function(_, $) {
    var LibraryView = function(options) {
        this.el = options.el;
        this.el.find(".retrieve-books").click(_.bind(this.getLibrary, this));
    };

    _.extend(LibraryView.prototype, {
        url: function() {
            var libraryId = this.el.find(".library-input").val();
            return "http://localhost:8080/library/" + libraryId;
        },

        getLibrary: function() {
            $.ajax(this.url(), {
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