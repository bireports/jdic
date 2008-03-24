/*
 * Copyright (C) 2008 Sun Microsystems, Inc. All rights reserved. Use is
 * subject to license terms.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the Lesser GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA.
 */

package org.jdic.web;

import java.awt.*;
import org.jdic.web.peer.WBrComponentPeer;
import org.jdic.web.peer.BrComponentPeer;

/**
 * The browser peers provider. Class customize the peer in accordance with OS 
 * and user preferences.
 * @author uta
 */
public class PeerClassFactory{
    static public BrComponentPeer createBrComponentPeer(BrComponent target){
        if( target.getToolkit() instanceof sun.awt.windows.WToolkit){
            WBrComponentPeer peer = new WBrComponentPeer(target);
            //AWTAutoShutdown.getInstance().registerPeer(target, peer);
            return peer;
        }
        return null;
    }
    static public void destroyBrComponentPeer(BrComponentPeer peer){
        if(null!=peer){
            peer.destroy();
        }            
    }
}