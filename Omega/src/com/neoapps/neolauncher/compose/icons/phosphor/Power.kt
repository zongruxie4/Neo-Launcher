/*
 * This file is part of Neo Launcher
 * Copyright (c) 2026   Neo Launcher Team
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.neoapps.neolauncher.compose.icons.phosphor

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.neoapps.neolauncher.compose.icons.Phosphor

val Phosphor.Power: ImageVector
    get() {
        return Builder(
            name = "Power",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 256.0f,
            viewportHeight = 256.0f,
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)),
                stroke = null,
                strokeLineWidth = 0.0f,
                strokeLineCap = Butt,
                strokeLineJoin = Miter,
                strokeLineMiter = 1f,
                pathFillType = NonZero
            ) {
                moveTo(120f, 128f)
                verticalLineTo(48f)
                arcToRelative(8f, 8f, 0f, false, true, 16f, 0f)
                verticalLineTo(128f)
                arcToRelative(8f, 8f, 0f, false, true, -16f, 0f)
                close()

                moveTo(180.37f, 49.3f)
                arcToRelative(8f, 8f, 0f, false, false, -8.74f, 13.4f)
                curveTo(194.74f, 77.77f, 208f, 101.57f, 208f, 128f)
                arcToRelative(80f, 80f, 0f, false, true, -160f, 0f)
                curveToRelative(0f, -26.43f, 13.26f, -50.23f, 36.37f, -65.3f)
                arcToRelative(8f, 8f, 0f, false, false, -8.74f, -13.4f)
                curveTo(47.9f, 67.38f, 32f, 96.06f, 32f, 128f)
                arcToRelative(96f, 96f, 0f, false, false, 192f, 0f)
                curveTo(224f, 96.06f, 208.1f, 67.38f, 180.37f, 49.3f)
                close()
            }
        }
            .build()
    }
