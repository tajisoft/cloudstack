# Copyright (C) 2003-2007  Robey Pointer <robeypointer@gmail.com>
# Copyright 2012 Citrix Systems, Inc. Licensed under the
# Apache License, Version 2.0 (the "License"); you may not use this
# file except in compliance with the License.  Citrix Systems, Inc.
# reserves all rights not expressly granted by the License.
# You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
# 
# Automatically generated by addcopyright.py at 04/03/2012
# 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA.

"""
Resource manager.
"""

import weakref


class ResourceManager (object):
    """
    A registry of objects and resources that should be closed when those
    objects are deleted.
    
    This is meant to be a safer alternative to python's C{__del__} method,
    which can cause reference cycles to never be collected.  Objects registered
    with the ResourceManager can be collected but still free resources when
    they die.
    
    Resources are registered using L{register}, and when an object is garbage
    collected, each registered resource is closed by having its C{close()}
    method called.  Multiple resources may be registered per object, but a
    resource will only be closed once, even if multiple objects register it.
    (The last object to register it wins.)
    """
    
    def __init__(self):
        self._table = {}
        
    def register(self, obj, resource):
        """
        Register a resource to be closed with an object is collected.
        
        When the given C{obj} is garbage-collected by the python interpreter,
        the C{resource} will be closed by having its C{close()} method called.
        Any exceptions are ignored.
        
        @param obj: the object to track
        @type obj: object
        @param resource: the resource to close when the object is collected
        @type resource: object
        """
        def callback(ref):
            try:
                resource.close()
            except:
                pass
            del self._table[id(resource)]

        # keep the weakref in a table so it sticks around long enough to get
        # its callback called. :)
        self._table[id(resource)] = weakref.ref(obj, callback)


# singleton
ResourceManager = ResourceManager()
