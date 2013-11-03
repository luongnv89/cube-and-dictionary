subroutine MPI_Sizeof0DCH(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  character, intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_CHARACTER
  ierr = 0
end subroutine MPI_Sizeof0DCH

subroutine MPI_Sizeof0DL(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  logical, intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_LOGICAL
  ierr = 0
end subroutine MPI_Sizeof0DL

subroutine MPI_Sizeof0DI1(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  integer*1, intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_INT1
  ierr = 0
end subroutine MPI_Sizeof0DI1

subroutine MPI_Sizeof0DI2(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  integer*2, intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_INT2
  ierr = 0
end subroutine MPI_Sizeof0DI2

subroutine MPI_Sizeof0DI4(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  integer*4, intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_INT4
  ierr = 0
end subroutine MPI_Sizeof0DI4

subroutine MPI_Sizeof0DI8(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  integer*8, intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_INT8
  ierr = 0
end subroutine MPI_Sizeof0DI8

subroutine MPI_Sizeof0DR4(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  real*4, intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_REAL4
  ierr = 0
end subroutine MPI_Sizeof0DR4

subroutine MPI_Sizeof0DR8(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  real*8, intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_REAL8
  ierr = 0
end subroutine MPI_Sizeof0DR8

subroutine MPI_Sizeof0DR16(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  real*16, intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_REAL16
  ierr = 0
end subroutine MPI_Sizeof0DR16

subroutine MPI_Sizeof0DC8(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  complex*8, intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_COMPLEX8
  ierr = 0
end subroutine MPI_Sizeof0DC8

subroutine MPI_Sizeof0DC16(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  complex*16, intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_COMPLEX16
  ierr = 0
end subroutine MPI_Sizeof0DC16

subroutine MPI_Sizeof0DC32(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  complex*32, intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_COMPLEX32
  ierr = 0
end subroutine MPI_Sizeof0DC32

subroutine MPI_Sizeof1DCH(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  character, dimension(*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_CHARACTER
  ierr = 0
end subroutine MPI_Sizeof1DCH

subroutine MPI_Sizeof1DL(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  logical, dimension(*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_LOGICAL
  ierr = 0
end subroutine MPI_Sizeof1DL

subroutine MPI_Sizeof1DI1(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  integer*1, dimension(*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_INT1
  ierr = 0
end subroutine MPI_Sizeof1DI1

subroutine MPI_Sizeof1DI2(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  integer*2, dimension(*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_INT2
  ierr = 0
end subroutine MPI_Sizeof1DI2

subroutine MPI_Sizeof1DI4(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  integer*4, dimension(*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_INT4
  ierr = 0
end subroutine MPI_Sizeof1DI4

subroutine MPI_Sizeof1DI8(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  integer*8, dimension(*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_INT8
  ierr = 0
end subroutine MPI_Sizeof1DI8

subroutine MPI_Sizeof1DR4(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  real*4, dimension(*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_REAL4
  ierr = 0
end subroutine MPI_Sizeof1DR4

subroutine MPI_Sizeof1DR8(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  real*8, dimension(*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_REAL8
  ierr = 0
end subroutine MPI_Sizeof1DR8

subroutine MPI_Sizeof1DR16(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  real*16, dimension(*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_REAL16
  ierr = 0
end subroutine MPI_Sizeof1DR16

subroutine MPI_Sizeof1DC8(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  complex*8, dimension(*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_COMPLEX8
  ierr = 0
end subroutine MPI_Sizeof1DC8

subroutine MPI_Sizeof1DC16(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  complex*16, dimension(*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_COMPLEX16
  ierr = 0
end subroutine MPI_Sizeof1DC16

subroutine MPI_Sizeof1DC32(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  complex*32, dimension(*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_COMPLEX32
  ierr = 0
end subroutine MPI_Sizeof1DC32


subroutine MPI_Sizeof2DCH(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  character, dimension(1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_CHARACTER
  ierr = 0
end subroutine MPI_Sizeof2DCH

subroutine MPI_Sizeof2DL(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  logical, dimension(1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_LOGICAL
  ierr = 0
end subroutine MPI_Sizeof2DL

subroutine MPI_Sizeof2DI1(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  integer*1, dimension(1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_INT1
  ierr = 0
end subroutine MPI_Sizeof2DI1

subroutine MPI_Sizeof2DI2(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  integer*2, dimension(1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_INT2
  ierr = 0
end subroutine MPI_Sizeof2DI2

subroutine MPI_Sizeof2DI4(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  integer*4, dimension(1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_INT4
  ierr = 0
end subroutine MPI_Sizeof2DI4

subroutine MPI_Sizeof2DI8(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  integer*8, dimension(1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_INT8
  ierr = 0
end subroutine MPI_Sizeof2DI8

subroutine MPI_Sizeof2DR4(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  real*4, dimension(1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_REAL4
  ierr = 0
end subroutine MPI_Sizeof2DR4

subroutine MPI_Sizeof2DR8(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  real*8, dimension(1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_REAL8
  ierr = 0
end subroutine MPI_Sizeof2DR8

subroutine MPI_Sizeof2DR16(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  real*16, dimension(1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_REAL16
  ierr = 0
end subroutine MPI_Sizeof2DR16

subroutine MPI_Sizeof2DC8(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  complex*8, dimension(1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_COMPLEX8
  ierr = 0
end subroutine MPI_Sizeof2DC8

subroutine MPI_Sizeof2DC16(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  complex*16, dimension(1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_COMPLEX16
  ierr = 0
end subroutine MPI_Sizeof2DC16

subroutine MPI_Sizeof2DC32(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  complex*32, dimension(1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_COMPLEX32
  ierr = 0
end subroutine MPI_Sizeof2DC32


subroutine MPI_Sizeof3DCH(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  character, dimension(1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_CHARACTER
  ierr = 0
end subroutine MPI_Sizeof3DCH

subroutine MPI_Sizeof3DL(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  logical, dimension(1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_LOGICAL
  ierr = 0
end subroutine MPI_Sizeof3DL

subroutine MPI_Sizeof3DI1(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  integer*1, dimension(1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_INT1
  ierr = 0
end subroutine MPI_Sizeof3DI1

subroutine MPI_Sizeof3DI2(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  integer*2, dimension(1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_INT2
  ierr = 0
end subroutine MPI_Sizeof3DI2

subroutine MPI_Sizeof3DI4(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  integer*4, dimension(1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_INT4
  ierr = 0
end subroutine MPI_Sizeof3DI4

subroutine MPI_Sizeof3DI8(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  integer*8, dimension(1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_INT8
  ierr = 0
end subroutine MPI_Sizeof3DI8

subroutine MPI_Sizeof3DR4(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  real*4, dimension(1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_REAL4
  ierr = 0
end subroutine MPI_Sizeof3DR4

subroutine MPI_Sizeof3DR8(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  real*8, dimension(1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_REAL8
  ierr = 0
end subroutine MPI_Sizeof3DR8

subroutine MPI_Sizeof3DR16(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  real*16, dimension(1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_REAL16
  ierr = 0
end subroutine MPI_Sizeof3DR16

subroutine MPI_Sizeof3DC8(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  complex*8, dimension(1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_COMPLEX8
  ierr = 0
end subroutine MPI_Sizeof3DC8

subroutine MPI_Sizeof3DC16(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  complex*16, dimension(1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_COMPLEX16
  ierr = 0
end subroutine MPI_Sizeof3DC16

subroutine MPI_Sizeof3DC32(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  complex*32, dimension(1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_COMPLEX32
  ierr = 0
end subroutine MPI_Sizeof3DC32


subroutine MPI_Sizeof4DCH(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  character, dimension(1,1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_CHARACTER
  ierr = 0
end subroutine MPI_Sizeof4DCH

subroutine MPI_Sizeof4DL(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  logical, dimension(1,1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_LOGICAL
  ierr = 0
end subroutine MPI_Sizeof4DL

subroutine MPI_Sizeof4DI1(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  integer*1, dimension(1,1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_INT1
  ierr = 0
end subroutine MPI_Sizeof4DI1

subroutine MPI_Sizeof4DI2(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  integer*2, dimension(1,1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_INT2
  ierr = 0
end subroutine MPI_Sizeof4DI2

subroutine MPI_Sizeof4DI4(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  integer*4, dimension(1,1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_INT4
  ierr = 0
end subroutine MPI_Sizeof4DI4

subroutine MPI_Sizeof4DI8(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  integer*8, dimension(1,1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_INT8
  ierr = 0
end subroutine MPI_Sizeof4DI8

subroutine MPI_Sizeof4DR4(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  real*4, dimension(1,1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_REAL4
  ierr = 0
end subroutine MPI_Sizeof4DR4

subroutine MPI_Sizeof4DR8(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  real*8, dimension(1,1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_REAL8
  ierr = 0
end subroutine MPI_Sizeof4DR8

subroutine MPI_Sizeof4DR16(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  real*16, dimension(1,1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_REAL16
  ierr = 0
end subroutine MPI_Sizeof4DR16

subroutine MPI_Sizeof4DC8(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  complex*8, dimension(1,1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_COMPLEX8
  ierr = 0
end subroutine MPI_Sizeof4DC8

subroutine MPI_Sizeof4DC16(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  complex*16, dimension(1,1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_COMPLEX16
  ierr = 0
end subroutine MPI_Sizeof4DC16

subroutine MPI_Sizeof4DC32(x, size, ierr)
  implicit none
  include 'fortran_sizes.h'
  complex*32, dimension(1,1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
  size = OMPI_SIZEOF_F90_COMPLEX32
  ierr = 0
end subroutine MPI_Sizeof4DC32





