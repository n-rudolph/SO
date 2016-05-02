#!/bin.bash
set -c -u

identify -verbose $1 | grep "date:create:"
