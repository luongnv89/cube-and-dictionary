#! /bin/sh
#
# Copyright (c) 2004-2006 The Trustees of Indiana University and Indiana
#                         University Research and Technology
#                         Corporation.  All rights reserved.
# Copyright (c) 2004-2005 The University of Tennessee and The University
#                         of Tennessee Research Foundation.  All rights
#                         reserved.
# Copyright (c) 2004-2005 High Performance Computing Center Stuttgart, 
#                         University of Stuttgart.  All rights reserved.
# Copyright (c) 2004-2005 The Regents of the University of California.
#                         All rights reserved.
# Copyright (c) 2006      Cisco Systems, Inc.  All rights reserved.
# $COPYRIGHT$
# 
# Additional copyrights may follow
# 
# $HEADER$
#

max_array_rank="4"

ikinds=" 1  2  4  8 "
rkinds=" 4  8  16 "
ckinds=" 8  16  32 "
size="small"

# fix up for broken generation scripts that don't properly compute the
# ranks variable before using it
ranks="1"
rank="2"
while test "`expr $rank \\<= $max_array_rank`" = "1"; do
    ranks="$ranks $rank"
    rank="`expr $rank + 1`"
done
unset rank

#
# Helper function
#
check_size() {
    # Sanity check
    if test "$1" != "trivial" -a "$1" != "small" -a "$1" != "medium" -a \
        "$1" != "large"; then
        echo "WARNING: unrecognized size: $1" >&2
    fi

    # Check the value
    output=0
    if test "$1" = "trivial"; then
        # Since we've got a trivial source, always build it (since
        # trivial is the smallest allowable size to build, and we
        # already verified above that the size is valid).
        output=1
    elif test "$1" = "small"; then
        # If we've got a small source, build it unless the user only
        # requested trivial.
        if test "$size" != "trivial"; then
            output=1
        fi
    elif test "$1" = "medium"; then
        # If we've got a medium source, build it only if the user
        # requested medium or large.
        if test "$size" = "medium" -o "$size" = "large"; then
            output=1
        fi
    elif test "$1" = "large"; then
        # If we've got a large source, build it only if the user
        # requested large.
        if test "$size" = "large"; then
            output=1
        fi
    fi
}
