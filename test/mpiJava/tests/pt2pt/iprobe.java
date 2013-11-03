/****************************************************************************

 MESSAGE PASSING INTERFACE TEST CASE SUITE

 Copyright IBM Corp. 1995

 IBM Corp. hereby grants a non-exclusive license to use, copy, modify, and
 distribute this software for any purpose and without fee provided that the
 above copyright notice and the following paragraphs appear in all copies.

 IBM Corp. makes no representation that the test cases comprising this
 suite are correct or are an accurate representation of any standard.

 In no event shall IBM be liable to any party for direct, indirect, special
 incidental, or consequential damage arising out of the use of this software
 even if IBM Corp. has been advised of the possibility of such damage.

 IBM CORP. SPECIFICALLY DISCLAIMS ANY WARRANTIES INCLUDING, BUT NOT LIMITED
 TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 PURPOSE.  THE SOFTWARE PROVIDED HEREUNDER IS ON AN "AS IS" BASIS AND IBM
 CORP. HAS NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES,
 ENHANCEMENTS, OR MODIFICATIONS.

****************************************************************************

 These test cases reflect an interpretation of the MPI Standard.  They are
 are, in most cases, unit tests of specific MPI behaviors.  If a user of any
 test case from this set believes that the MPI Standard requires behavior
 different than that implied by the test case we would appreciate feedback.

 Comments may be sent to:
    Richard Treumann
    treumann@kgn.ibm.com

****************************************************************************

 MPI-Java version :
    Sung-Hoon Ko(shko@npac.syr.edu)
    Northeast Parallel Architectures Center at Syracuse University
    09/10/99

****************************************************************************
*/

import mpi.*;

class iprobe {
  static public void main(String[] args) throws MPIException {

    int me,cnt,src,tag;
    int data[] = new int[1];
    boolean flag;
    Intracomm comm;
    Status status;
	
    MPI.Init(args);
    comm = MPI.COMM_WORLD;
    me = comm.Rank();
	

    if(me == 0) {
      data[0] = 7;
      comm.Send(data,0,1,MPI.INT,1,1);
    } 
    else if(me == 1)  {
      for(;;)  {
	status = comm.Iprobe(0,1);		
	if(status != null) break;
      }
	    
      src = status.source;
      if(src != 0)
	System.out.println("ERROR in MPI_Probe: src = "+src+", should be 0");
	    
      tag = status.tag;
      if(tag != 1)
	System.out.println("ERROR in MPI_Probe: tag = "+tag+", should be 1");
	    
      cnt = status.Get_count(MPI.INT);
      if(cnt != 1) 
	System.out.println("ERROR in MPI_Probe: cnt = "+cnt+", should be 1");
	    
      status = comm.Recv(data,0,cnt,MPI.INT,src,tag);
      if(data[0] != 7) 
	System.out.println("ERROR in MPI_Recv, data[0] = "+data[0]+" should be 7");
    }
	
    comm.Barrier();
    if(me == 0) System.out.println("Iprobe TEST COMPLETE\n");
    MPI.Finalize();
  }
}
