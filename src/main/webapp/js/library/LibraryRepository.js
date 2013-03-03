var LibraryRepository = (function($, _) {
    var LibraryRepository = function() {
        this.urlRoot = "http://localhost:8080/library/";
    }

    _.extend(LibraryRepository.prototype, {
        getLibrary: function(libraryId) {
            var libraryPromise = $.ajax(this.urlRoot + libraryId, {
                accepts: {
                    json: 'application/json'
                }
            });

            return libraryPromise;
        }
    });

    return LibraryRepository;
}(jQuery, _));