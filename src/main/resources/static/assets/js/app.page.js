class App {
    static DOMAIN = location.origin;

    static BASE_URL = this.DOMAIN + "/api"
    static BASE_URL_AUTH = this.BASE_URL + "/auth"
    static BASE_URL_CATEGORY = this.BASE_URL + "/categories"
    static BASE_URL_PRODUCT = this.BASE_URL + "/products"

    static AlertMessageEn = class {
        static ERROR_400 = "The operation failed, please check the data again.";
        static ERROR_401 = "Unauthorized - Your access token has expired or is not valid.";
        static ERROR_403 = "Forbidden - You are not authorized to access this resource.";
        static ERROR_404 = "Not Found - The resource has been removed or does not exist";
        static ERROR_500 = "Internal Server Error - The server system is having problems or cannot be accessed.";
    }

    static SweetAlert = class {
        static showDeleteConfirmDialog() {
            return Swal.fire({
                icon: 'warning',
                text: 'Are you sure to delete the selected product ?',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, please delete this product !',
                cancelButtonText: 'Cancel',
            })
        }

        static showSuccessAlert(t) {
            Swal.fire({
                icon: 'success',
                title: t,
                position: 'top-end',
                showConfirmButton: false,
                timer: 1500
            })
        }

        static showErrorAlert(t) {
            Swal.fire({
                icon: 'error',
                title: 'Error',
                text: t,
            })
        }

        static showError401() {
            Swal.fire({
                icon: 'error',
                title: 'Access Denied',
                text: 'Invalid credentials!',
            })
        }

        static showError403() {
            Swal.fire({
                icon: 'error',
                title: 'Access Denied',
                text: 'You are not authorized to perform this function!',
            })
        }

        static showError500() {
            Swal.fire({
                icon: 'error',
                title: 'Access Denied',
                text: 'Internal Server Error - The server system is having problems or cannot be accessed.',
            })
        }
    }
}