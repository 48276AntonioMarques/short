package pt.isel.SHORT

class ClassLoaderException(message: String, cause: Throwable) : RuntimeException(message, cause)
class PageNotFoundException(message: String) : RuntimeException(message)
class PageLinkageException(message: String) : RuntimeException(message)
class ResourceNotFoundException(message: String) : RuntimeException(message)
