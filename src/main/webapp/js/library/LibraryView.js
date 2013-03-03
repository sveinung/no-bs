var LibraryView = (function(_, $) {
    var LibraryView = function(options) {
        this.el = options.el;
        this.libraryRepository = options.libraryRepository;

        this.el.find(".retrieve-books").click(_.bind(this.getLibrary, this));
    };

    _.extend(LibraryView.prototype, {
        libraryId: function() {
            return this.el.find(".library-input").val();
        },

        getLibrary: function() {
            this.libraryRepository.getLibrary(this.libraryId()).done(_.bind(this.libraryReceived, this));
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